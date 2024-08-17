package com.example.atividade2;

import java.util.ArrayList;
import java.util.List;

public class MediasDeCalor {   
    private List<IlhaDeCalor> ilhasDeCalor = new ArrayList<>();

    public MediasDeCalor() {
        ilhasDeCalor.add(new IlhaDeCalor(1, "Itaqua", "Vl Uruslina"));
    }

    public List<IlhaDeCalor> getIlhasDeCalor() {
        return this.ilhasDeCalor;
    }

    public void adicionarMediaDeCalor(IlhaDeCalor ilhaDeCalor){
        this.ilhasDeCalor.add(ilhaDeCalor);
    }
    
}
