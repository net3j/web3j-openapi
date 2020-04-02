/*
 * Copyright 2020 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3j.api

import org.web3j.api.model.GreeterDeployParameters
import org.web3j.api.model.NewGreetingParameters
import org.web3j.protocol.core.methods.response.TransactionReceipt
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/api/contracts")
interface GreeterResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun deploy(greetingParameters: GreeterDeployParameters): TransactionReceipt

    @POST
    @Path("{contractAddress}/newGreeting")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun newGreeting(
        @PathParam("contractAddress") contractAddress: String,
        newGreetingParameters: NewGreetingParameters
    ): TransactionReceipt

    @GET
    @Path("{contractAddress}/greet")
    @Produces(MediaType.TEXT_PLAIN)
    fun greet(@PathParam("contractAddress") contractAddress: String): String
}
