package ecdc.core

import ecdc.core.TraitReader.ServiceTrait
import ecdc.core.VariableResolver._
import java.io.File
import model.Cluster
import testutils.Spec

class VariableResolverSpec extends Spec {
  it should "resolve variables for traits" in {
    val vars = resolveVariables(new File("./src/core/src/test/resources/testRepo"), Seq(ServiceTrait("logging"), ServiceTrait("syslog")), Cluster("production"))
    vars should have size 3
    vars should contain(Variable("LOGGING_SERVICE_KEY", "logging_service_key_production", "trait/logging/cluster/production/var"))
  }
}
