package com.example.ec2isaac;

import androidx.fragment.app.Fragment;

public interface NavigationHost {

    void navigateTo(Fragment fragment, boolean addToBackStack);
}
