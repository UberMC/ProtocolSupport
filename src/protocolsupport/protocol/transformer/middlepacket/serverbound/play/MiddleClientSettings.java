package protocolsupport.protocol.transformer.middlepacket.serverbound.play;

import net.minecraft.server.v1_9_R1.Packet;
import protocolsupport.protocol.ServerBoundPacket;
import protocolsupport.protocol.transformer.middlepacket.ServerBoundMiddlePacket;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketCreator;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public abstract class MiddleClientSettings extends ServerBoundMiddlePacket {

	protected String locale;
	protected int viewDist;
	protected int chatMode;
	protected boolean chatColors;
	protected int skinFlags;
	protected int mainHand;

	@Override
	public RecyclableCollection<? extends Packet<?>> toNative() throws Exception {
		PacketCreator creator = PacketCreator.create(ServerBoundPacket.PLAY_SETTINGS.get());
		creator.writeString(locale);
		creator.writeByte(viewDist);
		creator.writeByte(chatMode);
		creator.writeBoolean(chatColors);
		creator.writeByte(skinFlags);
		creator.writeVarInt(mainHand);
		return RecyclableSingletonList.create(creator.create());
	}

}
