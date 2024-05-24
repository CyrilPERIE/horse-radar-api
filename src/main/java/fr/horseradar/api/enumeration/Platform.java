package fr.horseradar.api.enumeration;

public enum Platform {
	
    LEBONCOIN("LeBonCoin"),
    MARKETPLACE("MarketPlace"),
    INSTAGRAM("Instagram"),
    EQUIRADAR("EquiRadar");
	
    private final String name;
    
    Platform(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
}