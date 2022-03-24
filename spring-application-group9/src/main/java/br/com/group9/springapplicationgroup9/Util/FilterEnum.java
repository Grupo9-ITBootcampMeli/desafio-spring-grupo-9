package br.com.group9.springapplicationgroup9.Util;

import br.com.group9.springapplicationgroup9.Util.Interfaces.IFilter;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Enum de relação de filtros de acordo com o nome do RequestParam
public enum FilterEnum {
    nameFilter(new NameFilter(), "name"),
    categoryFilter(new CategoryFilter(), "category"),
    brandFilter(new BrandFilter(), "brand"),
    priceFilter(new PriceFilter(), "price"),
    freeShippingFilter(new FreeShippingFilter(), "freeShipping"),
    prestigeFilter(new PrestigeFilter(), "prestige");

    private IFilter filter;
    private String filterName;
    private static final Map<String,FilterEnum> ENUM_MAP;

    FilterEnum(IFilter a, String name) {
        this.filter = a;
        this.filterName = name;
    }

    public IFilter getFilter(){
        return this.filter;
    }
    public String getName(){
        return this.filterName;
    }

    static {
        Map<String,FilterEnum> map = new ConcurrentHashMap<String, FilterEnum>();
        for (FilterEnum instance : FilterEnum.values()) {
            map.put(instance.getName().toLowerCase(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static FilterEnum get (String name) {
        return ENUM_MAP.get(name.toLowerCase());
    }
}
