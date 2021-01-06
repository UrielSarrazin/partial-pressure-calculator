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

package com.urielsarrazin.ppc;

import com.urielsarrazin.ppc.calculator.PartialPressuresCalculResult;
import com.urielsarrazin.ppc.core.BreathingMix;
import com.urielsarrazin.ppc.core.Gas;
import com.urielsarrazin.ppc.core.Pressure;
import com.urielsarrazin.ppc.service.BreathingMixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@ShellComponent
public class Command {

    @Autowired
    private BreathingMixService breathingMixService;

    @ShellMethod(
        value = "Calculate partial pressure of breathing mix components by depth.",
        group = "Physical Commands"
    )
    public String gasPartialPressure(@ShellOption final BreathingMix breathingMix) {
        final List<PartialPressuresCalculResult> partialPressuresCalculResults = breathingMixService.calculatePartialPressures(breathingMix);
        return formatResultForDisplay(partialPressuresCalculResults);
    }

    private String formatResultForDisplay(List<PartialPressuresCalculResult> partialPressuresCalculResults) {

        final StringBuilder result = new StringBuilder();

        for (PartialPressuresCalculResult partialPressuresCalculResult : partialPressuresCalculResults) {

            result
                    .append(partialPressuresCalculResult.getBreathingMix())
                    .append("\t")
                    .append(partialPressuresCalculResult.getDepth().getMeters());

            for (Map.Entry<Gas, Pressure> gasPartialPressure : partialPressuresCalculResult.getPartialPressuresPerGas().entrySet())
                result
                        .append("\t")
                        .append(gasPartialPressure.getKey())
                        .append("\t")
                        .append(new BigDecimal(gasPartialPressure.getValue().getBar()).setScale(2, RoundingMode.HALF_UP).doubleValue());

            result.append("\n");
        }

        return result.toString();
    }
}