package zip.vinkyv.launchpads;

import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.math.Vector3;

public class EventListener implements Listener {
  public List<Integer> blocks = MainPlugin.blocks;     //Set blocks list from MainPlugin
  public List<Integer> multiple = MainPlugin.multiple; //Set multiple list from MainPlugin

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    Block block = player.getLevel().getBlock(event.getTo().subtract(0, 1, 0)); // Get block under player
    if (blocks.contains(block.getId())) {
      Integer multiplier = multiple.get(blocks.indexOf(block.getId())); // Find index of block id in List from config and get multiplier of it
      Vector3 velocity = player.getDirectionVector().multiply(multiplier).setY(1); // Multiply direction on configurated multiplier, Y = 1 to implement jump
      player.setMotion(velocity); //Launch player
    }
  }
}
