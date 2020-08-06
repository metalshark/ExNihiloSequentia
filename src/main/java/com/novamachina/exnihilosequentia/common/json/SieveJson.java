package com.novamachina.exnihilosequentia.common.json;

import com.novamachina.exnihilosequentia.common.item.mesh.EnumMesh;

public class SieveJson {
    @JsonRequired
    private final String input;
    @JsonRequired
    private final String result;
    @JsonRequired
    private final Float rarity;
    @JsonRequired
    private final EnumMesh mesh;
    public SieveJson(String input, String result, Float rarity, EnumMesh mesh) {
        this.input = input;
        this.result = result;
        this.rarity = rarity;
        this.mesh = mesh;
    }

    public String getInput() {
        return input;
    }

    public String getResult() {
        return result;
    }

    public Float getRarity() {
        return rarity;
    }

    public EnumMesh getMesh() {
        return mesh;
    }
}
