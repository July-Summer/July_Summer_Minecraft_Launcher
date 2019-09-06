package github.July_Summer.JSML;

import github.July_Summer.JSML.farme.ImageManager;
import github.July_Summer.JSML.farme.MainFarme;

/**
 * @author July_Summer
 */
public class Main {

	/**
	 * You may think you know what the following code does.
	 * But you dont. Trust me.
	 * Fiddle with it, and youll spend many a sleepless
	 * night cursing the moment you thought youd be clever
	 * enough to "optimize" the code below.
	 * Now close this file and go play with something else.
	 */
	
	public static void main(String[] args) {
		ImageManager.getInstance().load();
		MainFarme.init();
	}
	
}
