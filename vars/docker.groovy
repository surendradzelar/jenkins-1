 def call(Map params = [:] ) {
     def args = [
          SLAVE_LABEL : "DOCKER"
  ]
    pipeline {
        agent {
            label "${args.SLAVE_LABEL}"
        }
    
        environment {
            COMPONENT ="${args.COMPONENT}"
            //NEXUS_IP = "${args.NEXUS_IP}"
            PROJECT_NAME = "${args.PROJECT_NAME}"
            SLAVE_LABEL = "${args.SLAVE_LABEL}"
            APP_TYPE    = "${args.APP_TYPE}"
        }
        stages {
            stage('Build code & install dependencies') {
                steps {
                    sh ' docker build -t local .'
                    

                    }
                }

            }
            //stage('Prepare Artifacts') {

              //  steps {
                //    script {
                  //      prepare = new nexus()
                    //    prepare.make_artifacts("${APP_TYPE}","${COMPONENT}")
                    //}
                //}
            //}

            //stage('Upload Artifacts') {
              //  steps {
                //    script {
                  //      prepare = new nexus()
                    //    prepare.nexus(COMPONENT)
                    //}

                //}
            //}
            //stage('Depoly DEV env') {  
                //steps{
                  //sh '''build job : 'DEPLOYMENT-PIPELINES'''
                    //parameters: [string(name:'ENV',value:'dev') string(name:'COMPONENT', value:"${COMPONENT}") string(name:'version', value:"${get_branch_exec}")]
                //}
           //}
        //}
    //}

 }
 }