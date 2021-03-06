/*******************************************************************************
 * Copyright (c) 2016 Silverspoon.io (silverspoon@silverware.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package io.silverspoon.bulldog.raspberrypi;

import io.silverspoon.bulldog.core.platform.Board;
import io.silverspoon.bulldog.core.platform.BoardFactory;
import io.silverspoon.bulldog.linux.sysinfo.CpuInfo;
import io.silverspoon.bulldog.linux.util.LinuxLibraryLoader;

public class RaspberryPiBoardFactory implements BoardFactory {

   @Override
   public boolean isCompatibleWithPlatform() {
      // if broadcom chip is present
      return CpuInfo.getHardware().contains("BCM");
   }

   @Override
   public Board createBoard() {
      LinuxLibraryLoader.loadNativeLibrary("raspberrypi");
      return new RaspberryPi();
   }
}
