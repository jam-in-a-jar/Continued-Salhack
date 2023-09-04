package me.ionar.salhack.module.ui;

import me.ionar.salhack.events.render.EventRenderGameOverlay;
import me.ionar.salhack.managers.HudManager;
import me.ionar.salhack.module.Module;
import me.ionar.salhack.module.Value;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;

public final class HudModule extends Module
{
    public static final Value<Integer> ExtraTab = new Value<Integer>("ExtraTab", new String[]
            { "ET" }, "Max playerslots to show in the tab list", 80, 80, 1000, 10);

    public static final Value<Boolean> CustomFont = new Value<Boolean>("Custom Font", new String[]{ "CF" }, "Custom Font for Hud", true);

    public static final Value<Integer> Red = new Value<Integer>("Red", new String[] {"bRed"}, "Red for rendering", 242, 0, 255, 11);
    public static final Value<Integer> Green = new Value<Integer>("Green", new String[] {"bGreen"}, "Green for rendering", 216, 0, 255, 11);
    public static final Value<Integer> Blue = new Value<Integer>("Blue", new String[] {"bBlue"}, "Blue for rendering", 0, 0, 255, 11);

    public HudModule()
    {
        super("HUD", new String[]
                { "HUD" }, "Displays the HUD", 0, 0xD1DB24, ModuleType.UI);
    }

    @EventHandler
    private Listener<EventRenderGameOverlay> OnRenderGameOverlay = new Listener<>(p_Event ->
    {
        if (!mc.options.debugEnabled)
            HudManager.Get().OnRender(p_Event.PartialTicks, p_Event.getContext());
    });
}
