package sgw.kandidat.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import sgw.kandidat.dagger.App;
import sgw.kandidat.dagger.modules.AppModule;
import sgw.kandidat.dagger.modules.DataBaseModule;
import sgw.kandidat.dagger.modules.SharedPreferenceModule;

@Singleton
@Component(modules = {
        AppModule.class,
        SharedPreferenceModule.class,
        DataBaseModule.class,

})
/**
 * Application component. Source component for all sub-components.
 */

public interface AppComponent {

    void inject(App app);
    ActivityComponent getActivityComponent();
    final class Initializer {
        private Initializer() {}

        public static AppComponent init(App app) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .sharedPreferenceModule(new SharedPreferenceModule())
                    .dataBaseModule(new DataBaseModule())
                    .build();
        }
    }
}