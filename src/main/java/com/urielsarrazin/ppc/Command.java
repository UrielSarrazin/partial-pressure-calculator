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
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@Component
public class Command implements CommandMarker {

    @Autowired
    private BreathingMixService breathingMixService;

    @CliCommand(value = "partial-pressure")
    public String gasPartialPressure(
            @CliOption(key = {"breathingMix"})
            final BreathingMix breathingMix
    ) {

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

            result.append(OsUtils.LINE_SEPARATOR);
        }

        return result.toString();
    }
}