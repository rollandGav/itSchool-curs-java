package org.example.session34;


class SistemLumini{
    public void stingeLumina(){
        System.out.println("Luminile s-au stins");
    }
}

class SistemAudio{
    public void pornesteSistemulAudio(){
        System.out.println("sistemul audio este pornit");
    }
}

class SistemVideo{
    public void pornesteVideoproiector(){
        System.out.println("Videoproiector pornit");
    }
}

class SistemDraperii{
    public void trageDraperii(){
        System.out.println("draperii trase");
    }
}

class HomeCinameFacade{
    public SistemLumini sistemLumini;
    public SistemAudio sistemAudio;
    public SistemVideo sistemVideo;
    public SistemDraperii sistemDraperii;

    public HomeCinameFacade() {
        this.sistemLumini = new SistemLumini();
        this.sistemAudio = new SistemAudio();
        this.sistemVideo = new SistemVideo();
        this.sistemDraperii = new SistemDraperii();
    }

    public void pornesteFilm(){
        sistemLumini.stingeLumina();
        sistemAudio.pornesteSistemulAudio();
        sistemVideo.pornesteVideoproiector();
        sistemDraperii.trageDraperii();
    }
}


public class Facade {
    public static void main(String[] args) {
        HomeCinameFacade facade = new HomeCinameFacade();
        facade.pornesteFilm();
    }
}
