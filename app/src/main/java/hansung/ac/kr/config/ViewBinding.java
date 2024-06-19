package hansung.ac.kr.config;


import android.view.View;
import androidx.annotation.NonNull;

/** A type which binds the views in a layout XML to fields. */
public interface ViewBinding {
    /**
     * Returns the outermost {@link View} in the associated layout file. If this binding is for a
     * {@code <merge>} layout, this will return the first view inside of the merge tag.
     */
    @NonNull
    View getRoot();
}
