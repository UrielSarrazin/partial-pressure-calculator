/*
 * Copyright (C) 2016 Uriel Sarrazin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.urielsarrazin.ppc.core;

import java.util.Arrays;
import java.util.List;

import static com.urielsarrazin.ppc.core.Gas.*;

public enum BreathingMix {

    AIR(
            BreathingMixComponent.create(O2, Pourcentage.create(21D)),
            BreathingMixComponent.create(N2, Pourcentage.create(79D))
    ),

    NITROX_32_68(
            BreathingMixComponent.create(O2, Pourcentage.create(32D)),
            BreathingMixComponent.create(N2, Pourcentage.create(68D))
    ),

    NITROX_36_64(
            BreathingMixComponent.create(O2, Pourcentage.create(36D)),
            BreathingMixComponent.create(N2, Pourcentage.create(64D))
    ),

    NITROX_40_60(
            BreathingMixComponent.create(O2, Pourcentage.create(40D)),
            BreathingMixComponent.create(N2, Pourcentage.create(60D))
    ),

    OXYGEN(
            BreathingMixComponent.create(O2, Pourcentage.create(100D))
    ),

    TRIMIX_20_25(
            BreathingMixComponent.create(O2, Pourcentage.create(20D)),
            BreathingMixComponent.create(He, Pourcentage.create(25D)),
            BreathingMixComponent.create(N2, Pourcentage.create(55D))
    );

    private final List<BreathingMixComponent> breathingMixComponents;

    BreathingMix(BreathingMixComponent... breathingMixComponents) {
        this.breathingMixComponents = Arrays.asList(breathingMixComponents);
    }

    public List<BreathingMixComponent> getBreathingMixComponents() {
        return breathingMixComponents;
    }
}
