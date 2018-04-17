/*
   Copyright 2014-2018 Sam Gleske - https://github.com/samrocketman/jervis

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   */

import hudson.util.DescribableList
import hudson.util.XStream2
import jenkins.model.Jenkins
preserved_xml = [:]

//preserve job properties like credentials
if(Jenkins.instance.getItemByFullName(project)) {
    XStream2 xs = new XStream2()
    xs.alias('properties', DescribableList.class)
    String xml = xs.toXML(Jenkins.instance.getItemByFullName(project).properties)
    println xml
    preserved_xml['job_props'] = xml
}

