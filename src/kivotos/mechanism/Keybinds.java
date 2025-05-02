package kivotos.mechanism;

import arc.input.KeyBind;
import arc.input.KeyCode;

public class Keybinds {
    public static KeyBind exSkill;
    public static void loadKeybinds(){
        exSkill = KeyBind.add("exskill", KeyCode.q, "ArchiveDustry");
        exSkill.load();
    }
}
