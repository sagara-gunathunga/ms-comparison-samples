/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package sample.mss.jpa.service;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.wso2.carbon.mss.AbstractHttpHandler;
import org.wso2.carbon.mss.HttpResponder;
import sample.mss.jpa.dao.UserRepository;
import sample.mss.jpa.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/users")
public class UserService extends AbstractHttpHandler {

    private UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    @POST
    @Path("/fname/{fname}/lname/{lname}")
    //TODO
    // public void addUser(HttpRequest request, HttpResponder responder, User nUser) {
    public void addUser(HttpRequest request, HttpResponder responder, @PathParam("fname") String fname,
                        @PathParam("lname") String lname) {

        User user = new User(fname, lname);
        users.createUser(user);
        responder.sendStatus(HttpResponseStatus.ACCEPTED);
    }

    @GET
    @Path("/{id}")
    public void getUser(HttpRequest request, HttpResponder responder, @PathParam("id") long id) {
        User user = users.findUser(id);
        if (user != null) {
            responder.sendJson(HttpResponseStatus.ACCEPTED, user);
        }
        responder.sendStatus(HttpResponseStatus.NOT_FOUND);
    }

    @GET
    @Path("/")
    public void getUsers(HttpRequest request, HttpResponder responder) {
        responder.sendJson(HttpResponseStatus.ACCEPTED, users.findUsers());
    }

}
