/*
 * Copyright (C) 2016  Tobias Bielefeld
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * If you want to contact me, send me an e-mail at tobias.bielefeld@gmail.com
 */

package de.tobiasbielefeld.solitaire.ui.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.tobiasbielefeld.solitaire.LoadGame;
import de.tobiasbielefeld.solitaire.R;
import de.tobiasbielefeld.solitaire.checkboxpreferences.CheckBoxPreferenceFourColorMode;
import de.tobiasbielefeld.solitaire.checkboxpreferences.CheckBoxPreferenceHideAutoCompleteButton;
import de.tobiasbielefeld.solitaire.checkboxpreferences.CheckBoxPreferenceHideMenuButton;
import de.tobiasbielefeld.solitaire.checkboxpreferences.CheckBoxPreferenceHideScore;
import de.tobiasbielefeld.solitaire.checkboxpreferences.CheckBoxPreferenceHideTime;
import de.tobiasbielefeld.solitaire.classes.Card;
import de.tobiasbielefeld.solitaire.classes.CustomPreferenceFragment;
import de.tobiasbielefeld.solitaire.dialogs.DialogPreferenceBackgroundColor;
import de.tobiasbielefeld.solitaire.dialogs.DialogPreferenceCardBackground;
import de.tobiasbielefeld.solitaire.dialogs.DialogPreferenceCards;
import de.tobiasbielefeld.solitaire.dialogs.DialogPreferenceOnlyForThisGame;
import de.tobiasbielefeld.solitaire.dialogs.DialogPreferenceTextColor;
//import de.tobiasbielefeld.solitaire.helper.Sounds;

import static de.tobiasbielefeld.solitaire.SharedData.*;
import static de.tobiasbielefeld.solitaire.helper.Preferences.*;

/**
 * Settings activity created with the "Create settings activity" tool from Android Studio.
 */

public class Settings extends AppCompatPreferenceActivity {

    private Preference preferenceMenuBarPosition;
    private Preference preferenceMenuColumns;
    private Preference preferenceBackgroundVolume;
    private Preference preferenceMaxNumberUndos;
    private Preference preferenceGameLayoutMargins;

    private CheckBoxPreference preferenceSingleTapAllGames;
    private CheckBoxPreference preferenceTapToSelect;
    private CheckBoxPreference preferenceImmersiveMode;

    private DialogPreferenceCards preferenceCards;
    private DialogPreferenceCardBackground preferenceCardBackground;
    private DialogPreferenceBackgroundColor preferenceBackgroundColor;
    private DialogPreferenceTextColor preferenceTextColor;
    private DialogPreferenceOnlyForThisGame dialogPreferenceOnlyForThisGame;

    private CheckBoxPreferenceFourColorMode preferenceFourColorMode;
    private CheckBoxPreferenceHideAutoCompleteButton preferenceHideAutoCompleteButton;
    private CheckBoxPreferenceHideMenuButton preferenceHideMenuButton;
    private CheckBoxPreferenceHideScore preferenceHideScore;
    private CheckBoxPreferenceHideTime preferenceHideTime;

    private PreferenceCategory categoryOnlyForThisGame;

    CustomizationPreferenceFragment customizationPreferenceFragment;

    //private Sounds settingsSounds;

    //make this static so the preference fragments use the same intent
    //don't forget: Android 8 doesn't call onCreate for the fragments, so there only one intent is
    //created. Android 7 calls onCreate for each fragment and would create new intents
    static Intent returnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        reinitializeData(getApplicationContext());
        super.onCreate(savedInstanceState);

        ((ViewGroup) getListView().getParent()).setPadding(0, 0, 0, 0);     //remove huge padding in landscape

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        prefs.setCriticalSettings();

        //settingsSounds = new Sounds(this);

        if (returnIntent == null) {
            returnIntent = new Intent();
        }
    }

    @Override
    public boolean onIsMultiPane() {
        return isLargeTablet(this);
    }

    @Override
    public void onBuildHeaders(List<Header> target) {
        if (prefs.getShowAdvancedSettings()) {
            loadHeadersFromResource(R.xml.pref_headers_with_advanced_settings, target);
        } else {
            loadHeadersFromResource(R.xml.pref_headers, target);
        }

    }

    /*
     * Update settings when the shared preferences get new values. It uses a lot of if/else instead
     * of switch/case because only this way i can use getString() to get the xml values, otherwise
     * I would need to write the strings manually in the cases.
     */
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }

    @Override
    public void finish() {
        setResult(Activity.RESULT_OK, returnIntent);
        super.finish();
    }

    /**
     * Tests if a loaded fragment is valid
     *
     * @param fragmentName The name of the fragment to test
     * @return True if it's valid, false otherwise
     */
    protected boolean isValidFragment(String fragmentName) {

        return true;
    }

    private void updatePreferenceMenuColumnsSummary() {

    }

    private void updatePreferenceGameLayoutMarginsSummary() {

    }

    private void updatePreferenceMaxNumberUndos() {

    }

    private void updatePreferenceMenuBarPositionSummary() {

    }

    private void updatePreferenceBackgroundVolumeSummary() {

    }

    public static class CustomizationPreferenceFragment extends CustomPreferenceFragment {


    }

    public static class OtherPreferenceFragment extends CustomPreferenceFragment {


    }

    public static class SoundPreferenceFragment extends CustomPreferenceFragment {


    }

    public static class MenuPreferenceFragment extends CustomPreferenceFragment {


    }

    public static class AdditionalMovementsPreferenceFragment extends CustomPreferenceFragment {


    }

    public static class DeveloperOptionsPreferenceFragment extends CustomPreferenceFragment {

    }

    public static class ExpertSettingsPreferenceFragment extends CustomPreferenceFragment {


    }
}
