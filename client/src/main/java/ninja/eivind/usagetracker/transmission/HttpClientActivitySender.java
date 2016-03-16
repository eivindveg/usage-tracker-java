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

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.net.URL;
import java.util.Optional;
import java.util.Set;

public class HttpClientActivitySender implements ClientActivitySender {

    private final URL url;
    private final Validator validator;

    public HttpClientActivitySender(URL url) {
        this.url = url;
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public void send(ClientActivity activity) {
        Set<ConstraintViolation<ClientActivity>> violations = validator.validate(activity);
        Optional<ConstraintViolation<ClientActivity>> firstViolation = violations.stream().findAny();

        if (firstViolation.isPresent()) {
            throw new ValidationException("Unable to transmit activity: " + firstViolation.get().getMessage());
        }

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
