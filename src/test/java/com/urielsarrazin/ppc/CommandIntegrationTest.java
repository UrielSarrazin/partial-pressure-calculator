/*
 * Copyright (C) 2021 Uriel Sarrazin
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.util.ReflectionUtils.findMethod;

import com.urielsarrazin.ppc.core.BreathingMix;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.MethodTarget;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = {
    InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
    ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT + ".enabled=false"
})
public class CommandIntegrationTest {

    @Autowired
    private Shell shell;

    @Test
    public void testAdd() {
      Map<String, MethodTarget> commands = shell.listCommands();
      MethodTarget methodTarget = commands.get("gas-partial-pressure");
      assertThat(methodTarget, notNullValue());
      assertThat(methodTarget.getGroup(), is("Physical Commands"));
      assertThat(methodTarget.getHelp(), is("Calculate partial pressure of breathing mix components by depth."));
      assertThat(methodTarget.getMethod(), is(findMethod(Command.class, "gasPartialPressure", BreathingMix.class)));
      assertThat(methodTarget.getAvailability().isAvailable(), is(true));
    }
}
