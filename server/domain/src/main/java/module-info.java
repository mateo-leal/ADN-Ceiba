module com.ceiba.citas_medicas.domain {

    requires java.persistence;
    requires lombok;
    requires org.apache.commons.lang3;

    exports com.ceiba.citas_medicas.domain.model;
}