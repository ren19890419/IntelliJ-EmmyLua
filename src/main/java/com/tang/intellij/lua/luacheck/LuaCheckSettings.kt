/*
 * Copyright (c) 2017. tangzx(love.tangzx@qq.com)
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

package com.tang.intellij.lua.luacheck

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(name = "LuaCheckSettings", storages = arrayOf(Storage("other.xml")))
class LuaCheckSettings : PersistentStateComponent<LuaCheckSettings> {
    var luaCheck:String? = null
    var luaCheckArgs:String? = null

    override fun getState(): LuaCheckSettings = this

    override fun loadState(settings: LuaCheckSettings) {
        XmlSerializerUtil.copyBean(settings, this)
    }
    companion object {
        @JvmStatic fun getInstance(): LuaCheckSettings {
            return ServiceManager.getService(LuaCheckSettings::class.java)
        }
    }
}
