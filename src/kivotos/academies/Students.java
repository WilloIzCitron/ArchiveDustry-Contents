package kivotos.academies;

import arc.scene.ui.layout.Table;
import arc.util.Strings;
import arc.util.Time;
import kivotos.mechanism.ExSkill;
import mindustry.content.Fx;
import mindustry.entities.abilities.Ability;
import mindustry.entities.abilities.ArmorPlateAbility;
import mindustry.entities.abilities.ShieldArcAbility;
import mindustry.entities.abilities.ShieldRegenFieldAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.MechUnit;
import mindustry.gen.Sounds;
import mindustry.gen.Unit;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class Students {
    public static UnitType hoshino, shiroko;

    public static void load(){
        hoshino = new UnitType("hoshino"){{
            constructor = MechUnit::create;
            groundLayer = 70;
            mechStepParticles = true;
            stepShake = 0.01f;
            hitSize = 20f;
            legPairOffset = 2f;
            singleTarget = true;
            groundLayer = Layer.groundUnit;
            armor = 2.5f;
            health = 850 * armor;
            abilities.add(new ExSkill(){
                {
                    reload = 30f;
                }
                float ffMax = 30 * (health/200 * armor);

                @Override
                public void performExSkill(Unit unit) {
                    unit.shield = ffMax;
                    super.performExSkill(unit);
                }
            }, new ShieldArcAbility() {{
                y = -30f;
                angle = 60;
                radius = 40f;
                region = "kivotos-hoshino-shield";
                max = 600 * armor;
                angleOffset = 1f;
                whenShooting = false;
                regen = 0.50f + (60 * armor / 100);
            }});
            weapons.add(new Weapon("kivotos-hoshino-shotgun"){{
                top = false;
                reload = 12f;
                shootSound = Sounds.shotgun;
                mirror = true;
                x = -14f;
                shootY = 10f;
                range = 14.99998f;
                shootCone = 30f;
                bullet = new BasicBulletType(12f, 25){{
                    knockback = 3f;
                    width = 15f;
                    lifetime = 15f;
                    height = 17f;
                    hitSize = 8f;
                    shootEffect = Fx.shootBigColor;
                    smokeEffect = Fx.shootSmokeSquareSparse;
                    ammoMultiplier = 1.5f;
                    hitColor = backColor = trailColor = Pal.orangeSpark;
                    trailEffect = Fx.disperseTrail;
                }};
                shoot = new ShootSpread(15, 1.5f);

                inaccuracy = 1.2f;
                velocityRnd = 0.2f;
            }});
        }};
        shiroko = new UnitType("shiroko"){{
            constructor = MechUnit::create;
            mechStepParticles = true;
            stepShake = 0.01f;
            hitSize = 20f;
            legPairOffset = 2f;
            singleTarget = true;
            groundLayer = Layer.groundUnit;
            armor = 1.6f;
            health = 780 * armor;
        }};
    }
}
