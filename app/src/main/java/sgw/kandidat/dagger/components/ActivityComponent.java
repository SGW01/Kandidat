package sgw.kandidat.dagger.components;

import dagger.Subcomponent;
import sgw.kandidat.ui.MainActivity;
import sgw.kandidat.ui.Results;

@Subcomponent
/** Activity component. Used to handle activity related DI into activities. */

public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(Results activity);

}