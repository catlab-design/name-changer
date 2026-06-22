package com.sammy.namechanger1_20_1.mixin.client;

import com.sammy.namechanger1_20_1.client.NicknameClientState;
import net.minecraft.client.multiplayer.chat.ChatListener;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.PlayerChatMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ChatListener.class)
public abstract class ChatListenerMixin {
    @ModifyVariable(
        method = "handlePlayerChatMessage",
        at = @At("HEAD"),
        argsOnly = true
    )
    private ChatType.Bound namechanger1_20_1$modifyBound(
        ChatType.Bound bound,
        PlayerChatMessage chatMessage
    ) {
        return NicknameClientState.getChatDisplayName(bound, chatMessage.sender());
    }
}
