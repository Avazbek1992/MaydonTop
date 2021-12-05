package uz.nits.maydontop.ui.home1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Home1ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Home1ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Home1 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}