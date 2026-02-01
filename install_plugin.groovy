import jenkins.model.Jenkins;

pm=Jenkins.instance.pluginManager
uc=Jenkins.instance.updateCenter

uc.updateAllSites()//zove katalog pluginova i skida sve informacije potrebene
["github","swarm","workflow-aggregator","docker-worflow"].each{
    if(! pm.getPlugin(it)){
        deployment = uc.getPlugin(it).deploy(true)
        deployment.get()
    }
}

Jenkins.instance.restart()
