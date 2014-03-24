package content;

import android.content.Context;

/**
 * A Factory class to retrieve the IContentManager instance. Created by Alex on 3/8/14.
 */
public class ContentManagerFactory {
	private static IContentManager Instance;

	/**
	 * Making this constructor private makes sure Java doesn't offer a generated one, from which a CMF could be created
	 * which then could create a second ContentManager, which would be undesired
	 */
	private ContentManagerFactory() {
		throw new IllegalStateException("Using the ContentManagerFactory constructor is illegal");
	}

	/**
     * @param context Used to retrieve application info, such as data folder location for the ContentManager
	 * @return Returns an instance of the ContentManager
	 */
	public static IContentManager getInstance(Context context) {
        if(Instance == null){
            Instance = new ContentManager(context);
        }
		return Instance;
	}
}