/*
 *  Copyright 2016 Eivind Vegsundvåg
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package ninja.eivind.usagetracker.transmission;

import ninja.eivind.usagetracker.ClientActivity;

import java.net.URL;

public class HttpClientActivitySender implements ClientActivitySender {

    private final URL url;

    public HttpClientActivitySender(URL url) {
        this.url = url;
    }

    @Override
    public void send(ClientActivity activity) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
