package kivotos.mechanism;

import arc.Core;
import arc.graphics.Color;
import arc.input.KeyBind;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;

import static kivotos.mechanism.Keybinds.exSkill;

public class ExSkill extends Ability {
    protected float data;
    public static float reload;
    public Effect skillActiveEffect = Fx.sparkExplosion;
    public Effect skillChargedEffect = Fx.shockwave;
    private boolean isCharged = false;

    @Override
    public void update(Unit unit) {
        super.update(unit);
        data += Time.delta;
        if (data >= reload){
            isCharged = true;
            if(Core.input.keyTap(exSkill) && unit.isPlayer()){
                skillActiveEffect.at(unit.x, unit.y, 12f, Color.white);
                if(!isCharged){skillChargedEffect.at(unit.x, unit.y, 12f, Color.white);}
                performExSkill(unit);
                data = 0;
                isCharged = false;
            }
        }
    }

    public void performExSkill(Unit unit){}
}
