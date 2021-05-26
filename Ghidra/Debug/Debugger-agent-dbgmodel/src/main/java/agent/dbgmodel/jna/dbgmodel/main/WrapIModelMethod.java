/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package agent.dbgmodel.jna.dbgmodel.main;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef.ULONGLONG;
import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.ptr.PointerByReference;

import agent.dbgmodel.jna.dbgmodel.UnknownWithUtils;

public class WrapIModelMethod extends UnknownWithUtils implements IModelMethod {
	public static class ByReference extends WrapIModelMethod implements Structure.ByReference {
	}

	public WrapIModelMethod() {
	}

	public WrapIModelMethod(Pointer pvInstance) {
		super(pvInstance);
	}

	@Override
	public HRESULT Call(Pointer pContextObject, ULONGLONG argCount, Pointer[] ppArguments,
			PointerByReference ppResult, PointerByReference ppMetadata) {
		return _invokeHR(VTIndices.CALL, getPointer(), pContextObject, argCount, ppArguments,
			ppResult, ppMetadata);
	}

}
