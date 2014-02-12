package mainmenuserver;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

public class PacketHandler
        implements IPacketHandler
{
    public static boolean connect = false;
    public static String server;
    public static int port = 25565;

    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
    {
        try
        {
            DataInputStream dis = new DataInputStream(new ByteArrayInputStream(packet.data));
            server = dis.readUTF();
            if (server.contains(":"))
            {
                String[] temp = server.split(Pattern.quote(":"));
                server = temp[0];
                port = Integer.parseInt(temp[1]);
            }
            Minecraft.getMinecraft().theWorld.sendQuittingDisconnectingPacket();
            connect = true;
        }
        catch (Throwable ex) {}
    }
}