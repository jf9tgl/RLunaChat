/*
 * @author     ucchy
 * @license    LGPLv3
 * @copyright  Copyright ucchy 2020
 */
package com.github.ucchyocean.lc3.bridge;

import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.mvplugins.multiverse.core.MultiverseCore;
import org.mvplugins.multiverse.core.MultiverseCoreApi;
import org.mvplugins.multiverse.core.world.MultiverseWorld;

/**
 * MultiverseCore連携クラス
 *
 * @author ucchy
 */
public class MultiverseCoreBridge {

    /**
     * MultiverseCore API クラス
     */
    private MultiverseCoreApi mvc;

    /**
     * コンストラクタは使用不可
     */
    private MultiverseCoreBridge() {
    }

    /**
     * MultiverseCore-apiをロードする
     *
     * @param plugin MultiverseCoreのプラグインインスタンス
     * @return ロードしたかどうか
     */
    public static MultiverseCoreBridge load(Plugin plugin) {

        if (plugin instanceof MultiverseCore) {
            MultiverseCoreBridge bridge = new MultiverseCoreBridge();
            bridge.mvc = MultiverseCoreApi.get();
            return bridge;
        } else {
            return null;
        }
    }

    /**
     * 指定されたワールドのエイリアス名を取得する
     *
     * @param worldName ワールド名
     * @return エイリアス名、取得できない場合はnullが返される
     */
    public String getWorldAlias(String worldName) {

        MultiverseWorld mvWorld = mvc.getWorldManager().getWorld(worldName).get();
        if (mvWorld != null) {
            if (!mvWorld.getAlias().isEmpty()) {
                return mvWorld.getAlias();
            } else {
                return mvWorld.getName();
            }
        } else {
            return null;
        }
    }

    /**
     * 指定されたワールドのエイリアス名を取得する
     *
     * @param world ワールド
     * @return エイリアス名、取得できない場合はnullが返される
     */
    public String getWorldAlias(World world) {

        MultiverseWorld mvWorld = mvc.getWorldManager().getWorld(world).get();
        if (mvWorld != null) {
            if (!mvWorld.getAlias().isEmpty()) {
                return mvWorld.getAlias();
            } else {
                return mvWorld.getName();
            }
        } else {
            return null;
        }
    }
}
