package github.July_Summer.JSML.farme;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

import github.July_Summer.JSML.farme.util.GaussianBlurUtil;

public class ImageManager {

	public static Image mainIcon;
	public static Image close;
	public static Image backgroundImage;
	public static Image launcher_backgroundImage;
	
	public void load() {
		mainIcon = getImage("mainIcon.ico");
	    close =  getImage("close.png");
	    backgroundImage = getImage("backgroundImage.jpg");
	    
	    ImageData launcher_data = backgroundImage.getImageData();
	    launcher_backgroundImage = new Image(MainFarme.display, launcher_data);
	}
	 
	public Image getImage(String fileName) {
		return new Image(MainFarme.display, getClass().getClassLoader().getResourceAsStream("images/" + fileName));
	}
	
	public static Image blur(Image image, int radius) {
		try {
			return createImage(GaussianBlurUtil.blur(ImageManager.getImageBytes(image), radius));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] getImageBytes(Image image) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		ImageLoader imageLoader = new ImageLoader();
		imageLoader.data = new ImageData[] { image.getImageData() };
		imageLoader.save(baos, image.type);
		byte[] imageByteArray = baos.toByteArray();

		try {
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return imageByteArray;
	}

	private static Image createImage(byte[] imageBytes) {
		Image image = null;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
			image = new Image(null, bais);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public static ImageManager getInstance() {
		return new ImageManager();
	}
}
