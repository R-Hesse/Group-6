/* Copyright (C) 2018  Tobias Bielefeld
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

package de.tobiasbielefeld.solitaire.dialogs;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import de.tobiasbielefeld.solitaire.R;
import de.tobiasbielefeld.solitaire.classes.CustomDialogPreference;
import de.tobiasbielefeld.solitaire.ui.settings.Settings;

import static android.content.Context.MODE_PRIVATE;
import static android.view.View.GONE;
import static de.tobiasbielefeld.solitaire.SharedData.createBulletParagraph;
import static de.tobiasbielefeld.solitaire.SharedData.*;
import static de.tobiasbielefeld.solitaire.helper.Preferences.*;

/**
 * Dialog to enable game individual settings.
 * The dialog has 4 "states":
 * - If the settings are opened from within a game, which doesn't have this enabled yet, the dialog
 * shows information about what this does and how to change settings for the other games
 * - Same situation, but the game HAS this enabled, the information will be, that the dialog will
 * restore the previous settings
 * - Settings are opened from the main menu: No individual settings possible, so the preference will
 * tell if some games have individual settings enabled, because they won't be affected by changes
 * - Settings are opened from the main menu, but NO game has individual settings enabled. So just
 * hide the preference somehow
 * <p>
 * The preference is placed in an own PreferenceCategory, otherwise the widget wouldn't update on
 * Android 8+ devices (bug?)
 */

public class DialogPreferenceOnlyForThisGame extends CustomDialogPreference {

    private Context context;
    private CheckBox widget;


    public DialogPreferenceOnlyForThisGame(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onBindDialogView(View view) {

        super.onBindDialogView(view);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {

        }




    /*
     * Get the layout from the preference, so I can get the imageView from the widgetLayout
     */
    @Override
    protected View onCreateView(ViewGroup parent) {
        View view = super.onCreateView(parent);
        view.setBackgroundResource(R.color.colorDrawerSelected);


        return view;
    }





}
