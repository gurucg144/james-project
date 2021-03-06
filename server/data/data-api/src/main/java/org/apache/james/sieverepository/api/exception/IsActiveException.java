/*
 *   Licensed to the Apache Software Foundation (ASF) under one
 *   or more contributor license agreements.  See the NOTICE file
 *   distributed with this work for additional information
 *   regarding copyright ownership.  The ASF licenses this file
 *   to you under the Apache License, Version 2.0 (the
 *   "License"); you may not use this file except in compliance
 *   with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 *
 */

package org.apache.james.sieverepository.api.exception;

public class IsActiveException extends SieveRepositoryException {
    /**
     * Creates a new instance of IsActiveException.
     *
     */
    public IsActiveException() {
        super();
    }

    /**
     * Creates a new instance of IsActiveException.
     *
     * @param message
     * @param cause
     */
    public IsActiveException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new instance of IsActiveException.
     *
     * @param message
     */
    public IsActiveException(String message) {
        super(message);
    }

    /**
     * Creates a new instance of IsActiveException.
     *
     * @param cause
     */
    public IsActiveException(Throwable cause) {
        super(cause);
    }

    private static final long serialVersionUID = 7472385325048232256L;
}