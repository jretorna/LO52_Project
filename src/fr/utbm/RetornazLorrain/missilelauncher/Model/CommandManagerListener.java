package fr.utbm.RetornazLorrain.missilelauncher.Model;

import java.util.EventListener;
import java.util.List;

public interface CommandManagerListener extends EventListener {
	void updateCommandList(final List<CommandLaunchedMessage> cmdList);
}
