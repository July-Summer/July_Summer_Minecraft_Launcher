package github.July_Summer.JSML;

import github.July_Summer.JSML.farme.ImageManager;
import github.July_Summer.JSML.farme.MainFarme;

/**
 * @author July_Summer
 */
public class Main {

	public static void main(String[] args) {
		ImageManager.getInstance().load();
		MainFarme.init();
	}
	
}
