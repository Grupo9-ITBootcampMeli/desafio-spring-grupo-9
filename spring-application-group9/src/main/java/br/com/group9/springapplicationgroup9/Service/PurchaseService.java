package br.com.group9.springapplicationgroup9.Service;

import br.com.group9.springapplicationgroup9.Dto.PurchaseDTO;
import br.com.group9.springapplicationgroup9.Dto.RequestPurchaseDTO;
import br.com.group9.springapplicationgroup9.Dto.ResponsePurchaseDTO;
import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Repository.ProductRepository;
import br.com.group9.springapplicationgroup9.Repository.PurchaseRepository;
import br.com.group9.springapplicationgroup9.Util.ProductHandler;
import br.com.group9.springapplicationgroup9.Util.PurchaseHandler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**Classe para o Service da Aplicação Springboot que lida com as requisições para os recursos associados a entidade
 * de purchase, onde serão contidos, valores e métodos para o mesmo.
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseService {
    private ProductRepository productRepository = new ProductRepository(new ProductHandler());
    private PurchaseRepository purchaseRepository = new PurchaseRepository(new PurchaseHandler());

    private List<Product> returnList = new ArrayList<Product>();
    private BigDecimal total = BigDecimal.ZERO;
    /**Método auxiliar utilizado na validação da requisição para criar uma compra. Recebe informação da quantidade da compra
     * do DTO para calcular o subtotal do produto e adiciona as informações do mesmo a lista de produtos (guardada
     * no estado da classe).

     * @param purchase RequestPurchaseDTO - DTO da request purchase necessária para chamada da função getTotal.
     * @param product Product - Produto a ser adicionado na lista de compras.
     */

    private void addPurchase(RequestPurchaseDTO purchase, Product product) {
        Product prod = new Product(product, purchase.getQuantity());
        returnList.add(prod);
        getTotal(purchase, product);
    }
    /**Método auxiliar utilizado na validação da requisição para criar uma compra. Adiciona o subtotal do produto
     * ao total da compra (guardado no estado da classe).

     * @param purchase RequestPurchaseDTO - DTO da request purchase necessária para calculo do subtotal.
     * @param product Product - Produto cujo subtotal será adicionado ao total da compra.
     */

    private void getTotal(RequestPurchaseDTO purchase, Product product) {
        BigDecimal subTotal = product.getPrice().multiply(BigDecimal.valueOf(purchase.getQuantity()));
        total = total.add(subTotal);
    }

    /**Método auxiliar utilizado na validação da requisição para criar uma compra. Responsável por checar se
     * o produto está registrado no repositório do produto e com quantidade em estoque.

     * @param purchase RequestPurchaseDTO - DTO da request purchase necessária verificação de estoque.
     * @param product Product - Produto cuja quantidade será verificada e existência confirmada
     * @return boolean - Confirma se o produto está presente e com estoque disponível para ser adquirido.
     */

    private boolean checkVal(RequestPurchaseDTO purchase, Product product) throws Exception {
        if (purchase.getProductId() == product.getProductId()) {
            if (purchase.getQuantity() > product.getQuantity()) {
                throw new Exception("O produto: " + product.getName() + " não possuí essa quantidade em estoque");
            }
            addPurchase(purchase, product);
            return true;
        }
        return false;
    }

    /**Método que itera pela lista de compra realizando validações e caso estas sejam bem sucedidas acaba por
     * chamar o repositório de compras para realizar a sua inserção

     * @param purchaseList Lista<RequestPurchaseDTO> - Lista de produtos a ser percorrida para execução das validações
     *                     e possível persistência.
     * @return PurchaseDTO - DTO do objeto parametrizado para ser enviado na resposta em caso de sucesso.
     */

    public PurchaseDTO createPurchase(List<RequestPurchaseDTO> purchaseList) throws Exception {
        List<Product> productList = productRepository.getAll();
        boolean contains = false;
        for (int i = 0; i < purchaseList.size(); i++) {
            contains = false;
            for (int j = 0; j < productList.size(); j++) {
                contains = checkVal(purchaseList.get(i), productList.get(j));
                if (contains) break;
            }
            if (!contains) {
                throw new Exception("O produto: " + purchaseList.get(i).getName() + " não existe na base de dados");
            }
        }
        PurchaseDTO purchase = new PurchaseDTO(returnList, total);
        purchaseRepository.add(purchase);
        return purchase;
    }

    /**Método que verifica as persistências de compras no repositório e as parametriza em um DTO que possui uma
     * lista das compras e o valor total de todas elas somadas.

     * @return ResponsePurchaseDTO - DTO da resposta a ser enviada ao cliente.
     */

    public ResponsePurchaseDTO listAll() throws Exception {
        List<PurchaseDTO> purchaseList = purchaseRepository.getAll();
        if (purchaseList.size() == 0) {
            throw new Exception("Não há compras realizadas");
        }
        BigDecimal totalPurchase = purchaseList.stream().map(a -> a.getTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
        ResponsePurchaseDTO responsePurchaseDTO = new ResponsePurchaseDTO(purchaseList, totalPurchase);
        return responsePurchaseDTO;
    }

}
