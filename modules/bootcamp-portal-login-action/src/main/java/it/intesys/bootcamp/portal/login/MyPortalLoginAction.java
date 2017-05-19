/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.intesys.bootcamp.portal.login;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.StrutsAction;
import org.osgi.service.component.annotations.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Liferay
 */
@Component(
	immediate = true, property = {"path=/portal/login"},
	service = StrutsAction.class
)
public class MyPortalLoginAction extends BaseStrutsAction {

    private Log _log = LogFactoryUtil.getLog(MyPortalLoginAction.class);

	public String execute(
                StrutsAction originalStrutsAction, HttpServletRequest request,
                HttpServletResponse response)
                throws Exception {

            _log.info("This is my 'portal' login action :)");
            return originalStrutsAction.execute(request, response);
	}

}