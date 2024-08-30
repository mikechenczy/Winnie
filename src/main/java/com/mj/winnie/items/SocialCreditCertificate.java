package com.mj.winnie.items;

import com.mj.winnie.setup.ModSetup;
import net.minecraft.item.Item;

public class SocialCreditCertificate extends Item {
    public SocialCreditCertificate() {
        super(new Item.Properties()
                .stacksTo(64)
                .tab(ModSetup.ITEM_GROUP));
    }
}
