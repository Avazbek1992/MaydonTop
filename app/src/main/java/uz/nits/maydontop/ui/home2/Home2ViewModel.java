package uz.nits.maydontop.ui.home2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Home2ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Home2ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Home2 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}