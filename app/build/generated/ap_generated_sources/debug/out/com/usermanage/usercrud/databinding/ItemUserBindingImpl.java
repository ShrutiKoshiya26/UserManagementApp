package com.usermanage.usercrud.databinding;
import com.usermanage.usercrud.R;
import com.usermanage.usercrud.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemUserBindingImpl extends ItemUserBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.editButton, 4);
        sViewsWithIds.put(R.id.deleteButton, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemUserBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemUserBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.ageTextView.setTag(null);
        this.emailTextView.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.nameTextView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.user == variableId) {
            setUser((com.usermanage.usercrud.data.model.User) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUser(@Nullable com.usermanage.usercrud.data.model.User User) {
        this.mUser = User;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int userAge = 0;
        com.usermanage.usercrud.data.model.User user = mUser;
        java.lang.String stringValueOfUserAge = null;
        java.lang.String javaLangStringEmailIDUserEmail = null;
        java.lang.String userName = null;
        java.lang.String userEmail = null;
        java.lang.String javaLangStringAgeStringValueOfUserAge = null;
        java.lang.String javaLangStringNameUserName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (user != null) {
                    // read user.age
                    userAge = user.getAge();
                    // read user.name
                    userName = user.getName();
                    // read user.email
                    userEmail = user.getEmail();
                }


                // read String.valueOf(user.age)
                stringValueOfUserAge = java.lang.String.valueOf(userAge);
                // read ("Name : ") + (user.name)
                javaLangStringNameUserName = ("Name : ") + (userName);
                // read ("Email ID : ") + (user.email)
                javaLangStringEmailIDUserEmail = ("Email ID : ") + (userEmail);


                // read ("Age : ") + (String.valueOf(user.age))
                javaLangStringAgeStringValueOfUserAge = ("Age : ") + (stringValueOfUserAge);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.ageTextView, javaLangStringAgeStringValueOfUserAge);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.emailTextView, javaLangStringEmailIDUserEmail);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nameTextView, javaLangStringNameUserName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): user
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}