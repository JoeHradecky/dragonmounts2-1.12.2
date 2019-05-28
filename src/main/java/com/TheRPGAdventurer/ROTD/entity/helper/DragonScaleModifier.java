/*
 ** 2013 October 31
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
<<<<<<< HEAD:src/main/java/com/TheRPGAdventurer/ROTD/entity/helper/DragonScaleModifier.java
package com.TheRPGAdventurer.ROTD.entity.helper;
=======
package com.TheRPGAdventurer.ROTD.entity.entitytameabledragon.helper;
>>>>>>> 487f066b... changes:src/main/java/com/TheRPGAdventurer/ROTD/entity/entitytameabledragon/helper/DragonScaleModifier.java

import net.minecraft.entity.ai.attributes.AttributeModifier;

import java.util.UUID;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class DragonScaleModifier extends AttributeModifier {
    
    public static final UUID ID = UUID.fromString("856d4ba4-9ffe-4a52-8606-890bb9be538b");

    public DragonScaleModifier(double amount) {
        super(ID, "Dragon size modifier", amount, 1);
        setSaved(false);
    }
}
