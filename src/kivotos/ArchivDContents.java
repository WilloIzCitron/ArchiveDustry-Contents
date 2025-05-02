package kivotos;


import kivotos.academies.Students;
import kivotos.mechanism.Keybinds;
import mindustry.mod.Mod;

public class ArchivDContents extends Mod {

    public ArchivDContents(){

    }

    @Override
    public void loadContent(){
        Keybinds.loadKeybinds();
        Students.load();
    }

}
