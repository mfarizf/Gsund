package com.example.gsund.ui.profile.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gsund.R;
import com.example.gsund.data.prefs.PreferencesManager;
import com.example.gsund.ui.profile.ProfileCallback;
import com.example.gsund.ui.profile.ProfilePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements ProfileCallback {
    @BindView(R.id.profil_nama)
    TextView nama;
    @BindView(R.id.profil_tb)
    TextView tinggiBadan;
    @BindView(R.id.profil_bb)
    TextView beratBadan;
    @BindView(R.id.profil_penyakit)
    TextView penyakit;
    @BindView(R.id.profil_umur)
    TextView umur;
    @BindView(R.id.profil_jenkel)
    TextView jenkel;
    @BindView(R.id.profil_nama_panggilan)
    TextView namaPanggilan;

    private ProfilePresenter profilePresenter;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        PreferencesManager preferencesManager = new PreferencesManager(getActivity());

        Realm.init(getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        Realm realm = Realm.getInstance(configuration);

        profilePresenter = new ProfilePresenter(getActivity(),this, realm, preferencesManager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profilePresenter.getUser(namaPanggilan,nama,tinggiBadan,beratBadan,penyakit,umur,jenkel);

    }
}
