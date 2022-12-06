/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techlim.core.facturacion.servicesri;

import com.google.gson.Gson;
import com.techlim.core.facturacion.servicesri.autorizacion.RespuestaComprobante;
import com.techlim.core.facturacion.servicesri.ws.autorizacion.AutorizacionComprobantesWs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author yunga
 */
public class AutorizacionTest {

    @Test
    public void TestAutorizacion() {
        String expected = "{\"claveAccesoConsultada\":\"0512202001060496755400120010020000033941234567812\",\"numeroComprobantes\":\"1\",\"autorizaciones\":[{\"estado\":\"AUTORIZADO\",\"numeroAutorizacion\":\"0512202001060496755400120010020000033941234567812\",\"fechaAutorizacion\":{\"year\":2020,\"month\":11,\"dayOfMonth\":5,\"hourOfDay\":19,\"minute\":31,\"second\":30},\"ambiente\":\"PRODUCCIÓN\",\"comprobante\":\"\\u003c?xml version\\u003d\\\"1.0\\\" encoding\\u003d\\\"UTF-8\\\"?\\u003e\\u003cfactura id\\u003d\\\"comprobante\\\" version\\u003d\\\"1.1.0\\\"\\u003e\\n    \\u003cinfoTributaria\\u003e\\n        \\u003cambiente\\u003e2\\u003c/ambiente\\u003e\\n        \\u003ctipoEmision\\u003e1\\u003c/tipoEmision\\u003e\\n        \\u003crazonSocial\\u003eYUNGAN GUALLI ELSA VERONICA\\u003c/razonSocial\\u003e\\n        \\u003cnombreComercial\\u003eLIBRERÍA UNIVERSITARIA\\u003c/nombreComercial\\u003e\\n        \\u003cruc\\u003e0604967554001\\u003c/ruc\\u003e\\n        \\u003cclaveAcceso\\u003e0512202001060496755400120010020000033941234567812\\u003c/claveAcceso\\u003e\\n        \\u003ccodDoc\\u003e01\\u003c/codDoc\\u003e\\n        \\u003cestab\\u003e001\\u003c/estab\\u003e\\n        \\u003cptoEmi\\u003e002\\u003c/ptoEmi\\u003e\\n        \\u003csecuencial\\u003e000003394\\u003c/secuencial\\u003e\\n        \\u003cdirMatriz\\u003eGUAYAQUIL Y ELOY ALFARO \\u003c/dirMatriz\\u003e\\n    \\u003c/infoTributaria\\u003e\\n    \\u003cinfoFactura\\u003e\\n        \\u003cfechaEmision\\u003e05/12/2020\\u003c/fechaEmision\\u003e\\n        \\u003cdirEstablecimiento\\u003eGUAYAQUIL Y ELOY ALFARO \\u003c/dirEstablecimiento\\u003e\\n        \\u003cobligadoContabilidad\\u003eNO\\u003c/obligadoContabilidad\\u003e\\n        \\u003ctipoIdentificacionComprador\\u003e07\\u003c/tipoIdentificacionComprador\\u003e\\n        \\u003crazonSocialComprador\\u003eConsumidor Final\\u003c/razonSocialComprador\\u003e\\n        \\u003cidentificacionComprador\\u003e9999999999999\\u003c/identificacionComprador\\u003e\\n        \\u003cdireccionComprador\\u003eN/A\\u003c/direccionComprador\\u003e\\n        \\u003ctotalSinImpuestos\\u003e0.31\\u003c/totalSinImpuestos\\u003e\\n        \\u003ctotalSubsidio\\u003e0\\u003c/totalSubsidio\\u003e\\n        \\u003ctotalDescuento\\u003e0\\u003c/totalDescuento\\u003e\\n        \\u003ctotalConImpuestos\\u003e\\n            \\u003ctotalImpuesto\\u003e\\n                \\u003ccodigo\\u003e2\\u003c/codigo\\u003e\\n                \\u003ccodigoPorcentaje\\u003e2\\u003c/codigoPorcentaje\\u003e\\n                \\u003cbaseImponible\\u003e0.31\\u003c/baseImponible\\u003e\\n                \\u003ctarifa\\u003e12\\u003c/tarifa\\u003e\\n                \\u003cvalor\\u003e0.04\\u003c/valor\\u003e\\n            \\u003c/totalImpuesto\\u003e\\n        \\u003c/totalConImpuestos\\u003e\\n        \\u003cpropina\\u003e0\\u003c/propina\\u003e\\n        \\u003cimporteTotal\\u003e0.35\\u003c/importeTotal\\u003e\\n        \\u003cmoneda\\u003eDOLAR\\u003c/moneda\\u003e\\n        \\u003cpagos\\u003e\\n            \\u003cpago\\u003e\\n                \\u003cformaPago\\u003e01\\u003c/formaPago\\u003e\\n                \\u003ctotal\\u003e0.35\\u003c/total\\u003e\\n            \\u003c/pago\\u003e\\n        \\u003c/pagos\\u003e\\n    \\u003c/infoFactura\\u003e\\n    \\u003cdetalles\\u003e\\n        \\u003cdetalle\\u003e\\n            \\u003ccodigoPrincipal\\u003e4.3.66.461\\u003c/codigoPrincipal\\u003e\\n            \\u003ccodigoAuxiliar\\u003e461\\u003c/codigoAuxiliar\\u003e\\n            \\u003cdescripcion\\u003eFUNDA DE REGALO 1 PEQUEÑA  T/C | FUNDAS DE REGALO\\u003c/descripcion\\u003e\\n            \\u003ccantidad\\u003e1\\u003c/cantidad\\u003e\\n            \\u003cprecioUnitario\\u003e0.3125\\u003c/precioUnitario\\u003e\\n            \\u003cdescuento\\u003e0\\u003c/descuento\\u003e\\n            \\u003cprecioTotalSinImpuesto\\u003e0.31\\u003c/precioTotalSinImpuesto\\u003e\\n            \\u003cimpuestos\\u003e\\n                \\u003cimpuesto\\u003e\\n                    \\u003ccodigo\\u003e2\\u003c/codigo\\u003e\\n                    \\u003ccodigoPorcentaje\\u003e2\\u003c/codigoPorcentaje\\u003e\\n                    \\u003ctarifa\\u003e12\\u003c/tarifa\\u003e\\n                    \\u003cbaseImponible\\u003e0.31\\u003c/baseImponible\\u003e\\n                    \\u003cvalor\\u003e0.04\\u003c/valor\\u003e\\n                \\u003c/impuesto\\u003e\\n            \\u003c/impuestos\\u003e\\n        \\u003c/detalle\\u003e\\n    \\u003c/detalles\\u003e\\n    \\u003cinfoAdicional\\u003e\\n        \\u003ccampoAdicional nombre\\u003d\\\"Contribuyente Régimen Microempresas\\\"\\u003e \\u003c/campoAdicional\\u003e\\n    \\u003c/infoAdicional\\u003e\\n\\u003cds:Signature xmlns:ds\\u003d\\\"http://www.w3.org/2000/09/xmldsig#\\\" xmlns:etsi\\u003d\\\"http://uri.etsi.org/01903/v1.3.2#\\\" Id\\u003d\\\"Signature639009\\\"\\u003e\\n\\u003cds:SignedInfo Id\\u003d\\\"Signature-SignedInfo238545\\\"\\u003e\\n\\u003cds:CanonicalizationMethod Algorithm\\u003d\\\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\\\"/\\u003e\\n\\u003cds:SignatureMethod Algorithm\\u003d\\\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\\\"/\\u003e\\n\\u003cds:Reference Id\\u003d\\\"SignedPropertiesID464653\\\" Type\\u003d\\\"http://uri.etsi.org/01903#SignedProperties\\\" URI\\u003d\\\"#Signature639009-SignedProperties492569\\\"\\u003e\\n\\u003cds:DigestMethod Algorithm\\u003d\\\"http://www.w3.org/2000/09/xmldsig#sha1\\\"/\\u003e\\n\\u003cds:DigestValue\\u003efbA4w4942khvkr/2iH/cFAbEfCQ\\u003d\\u003c/ds:DigestValue\\u003e\\n\\u003c/ds:Reference\\u003e\\n\\u003cds:Reference URI\\u003d\\\"#Certificate1313474\\\"\\u003e\\n\\u003cds:DigestMethod Algorithm\\u003d\\\"http://www.w3.org/2000/09/xmldsig#sha1\\\"/\\u003e\\n\\u003cds:DigestValue\\u003eP8oOUlmsr7XSjTcK+Uz3Tk1okRI\\u003d\\u003c/ds:DigestValue\\u003e\\n\\u003c/ds:Reference\\u003e\\n\\u003cds:Reference Id\\u003d\\\"Reference-ID-593387\\\" URI\\u003d\\\"#comprobante\\\"\\u003e\\n\\u003cds:Transforms\\u003e\\n\\u003cds:Transform Algorithm\\u003d\\\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\\\"/\\u003e\\n\\u003c/ds:Transforms\\u003e\\n\\u003cds:DigestMethod Algorithm\\u003d\\\"http://www.w3.org/2000/09/xmldsig#sha1\\\"/\\u003e\\n\\u003cds:DigestValue\\u003eYzjFKxHFQxfdWnKVFSFU9InO+nI\\u003d\\u003c/ds:DigestValue\\u003e\\n\\u003c/ds:Reference\\u003e\\n\\u003c/ds:SignedInfo\\u003e\\n\\u003cds:SignatureValue Id\\u003d\\\"SignatureValue688614\\\"\\u003e\\nmNJ3YOaeTbhNhSYJwOQoroYpK1F00K1v5qh9MQiFyv9zIMWthBMGDdRvG+56UNBXk3ooi16XN0hC\\nkRvEKit5EUoo1xw5VRi2f+53qZKyw0rW0/orYIQ4N1SJ0Ip+A3jXFimycfYaob+/Z/tJpUk8oRuO\\nJhmvBTOGKx+Tf0AD3xjBipJnzW4MNRS0zD47dIcMYfwbRmgJ7s/akH8meq5cJrcaEoGDbQBWyh4z\\nLCq2r39X6ZdPtXOQKkmd+RrwX9hC7ewGUvghEjtm7Sutx3xPkBMZ6d5kKaBhOhvdWk57Amz/I492\\nYtTREZJbn5hqPne2EIv0nLGohCiXgAmCX1gXMg\\u003d\\u003d\\n\\u003c/ds:SignatureValue\\u003e\\n\\u003cds:KeyInfo Id\\u003d\\\"Certificate1313474\\\"\\u003e\\n\\u003cds:X509Data\\u003e\\n\\u003cds:X509Certificate\\u003e\\nMIILmzCCCYOgAwIBAgIEaV25VTANBgkqhkiG9w0BAQsFADCBmTELMAkGA1UEBhMCRUMxHTAbBgNV\\nBAoMFFNFQ1VSSVRZIERBVEEgUy5BLiAxMTAwLgYDVQQLDCdFTlRJREFEIERFIENFUlRJRklDQUNJ\\nT04gREUgSU5GT1JNQUNJT04xOTA3BgNVBAMMMEFVVE9SSURBRCBERSBDRVJUSUZJQ0FDSU9OIFNV\\nQkNBLTEgU0VDVVJJVFkgREFUQTAeFw0yMDA1MjgyMzExMjBaFw0yMjA1MjgyMzExMjBaMIGbMQsw\\nCQYDVQQGEwJFQzEdMBsGA1UECgwUU0VDVVJJVFkgREFUQSBTLkEuIDExMDAuBgNVBAsMJ0VOVElE\\nQUQgREUgQ0VSVElGSUNBQ0lPTiBERSBJTkZPUk1BQ0lPTjEVMBMGA1UEBRMMMjgwNTIwMTgyMTIw\\nMSQwIgYDVQQDDBtFTFNBIFZFUk9OSUNBIFlVTkdBTiBHVUFMTEkwggEiMA0GCSqGSIb3DQEBAQUA\\nA4IBDwAwggEKAoIBAQDLtyoXmjovd5YCqP4t/OhTaXTw647XuK3KhAAgYSy4O++j16k8eqwhgnw0\\nbJLjd+uiEaCcD9o3Qfety/6M5KDFpkOjnzo2IfK4P0P/GiS5YOnP0ufAxCT9sKGx2vtfpBnF9+w5\\n6CZqZP1oFk/LAeJfoufaKlLpZyzQr0oH6bfoOLAkMfegz/xX6d8gzae9ks7qIE6OOCoEXyTQiCDr\\ns+vA96sL2Kv0D5691cqxj6+Z9WWFVVjIAi+l2NNhcKx9ef7LR/mgcBO7+gKqmGetZ+xlK6Ql2OL4\\nkKluEAebawA8N0b4Tfx3+I0pHu7VkhSrSE98jFXgZc1R8mdgZpnVE7FDAgMBAAGjggblMIIG4TBZ\\nBggrBgEFBQcBAQRNMEswSQYIKwYBBQUHMAGGPWh0dHA6Ly9vY3NwZ3cuc2VjdXJpdHlkYXRhLm5l\\ndC5lYy9lamJjYS9wdWJsaWN3ZWIvc3RhdHVzL29jc3AwHQYDVR0OBBYEFLBmE7HPnLiQfesfNza1\\noi1OKhD1MAwGA1UdEwEB/wQCMAAwHwYDVR0jBBgwFoAUXA+FpHQQ/K0BLBoAPZMXCfo5AdYwKwYD\\nVR0QBCQwIoAPMjAyMDA1MjgyMzExMjBagQ8yMDIyMDUyODIzMTEyMFowgcwGA1UdLgSBxDCBwTCB\\nvqCBu6CBuIaBtWxkYXA6Ly9sZGFwc2Quc2VjdXJpdHlkYXRhLm5ldC5lYy9DTj1BVVRPUklEQUQg\\nREUgQ0VSVElGSUNBQ0lPTiBTVUJDQS0xIFNFQ1VSSVRZIERBVEEsT1U9RU5USURBRCBERSBDRVJU\\nSUZJQ0FDSU9OIERFIElORk9STUFDSU9OLE89U0VDVVJJVFkgREFUQSBTLkEuIDEsQz1FQz9kZWx0\\nYVJldm9jYXRpb25MaXN0P2Jhc2UwgeIGA1UdIASB2jCB1zBaBgorBgEEAYKmcgIHMEwwSgYIKwYB\\nBQUHAgIwPh48AEMAZQByAHQAaQBmAGkAYwBhAGQAbwAgAGQAZQAgAFAAZQByAHMAbwBuAGEAIABO\\nAGEAdAB1AHIAYQBsMHkGCisGAQQBgqZyAgEwazBpBggrBgEFBQcCARZdaHR0cHM6Ly93d3cuc2Vj\\ndXJpdHlkYXRhLm5ldC5lYy9sZXllc19ub3JtYXRpdmFzL1BvbGl0aWNhcyBkZSBDZXJ0aWZpY2Fk\\nbyBQZXJzb25hIE5hdHVyYWwucGRmMIICngYDVR0fBIIClTCCApEwgeWgQaA/hj1odHRwOi8vb2Nz\\ncGd3LnNlY3VyaXR5ZGF0YS5uZXQuZWMvZWpiY2EvcHVibGljd2ViL3N0YXR1cy9vY3NwooGfpIGc\\nMIGZMTkwNwYDVQQDDDBBVVRPUklEQUQgREUgQ0VSVElGSUNBQ0lPTiBTVUJDQS0xIFNFQ1VSSVRZ\\nIERBVEExMDAuBgNVBAsMJ0VOVElEQUQgREUgQ0VSVElGSUNBQ0lPTiBERSBJTkZPUk1BQ0lPTjEd\\nMBsGA1UECgwUU0VDVVJJVFkgREFUQSBTLkEuIDExCzAJBgNVBAYTAkVDMIHEoIHBoIG+hoG7bGRh\\ncDovL2xkYXBzZC5zZWN1cml0eWRhdGEubmV0LmVjL0NOPUFVVE9SSURBRCBERSBDRVJUSUZJQ0FD\\nSU9OIFNVQkNBLTEgU0VDVVJJVFkgREFUQSxPVT1FTlRJREFEIERFIENFUlRJRklDQUNJT04gREUg\\nSU5GT1JNQUNJT04sTz1TRUNVUklUWSBEQVRBIFMuQS4gMSxDPUVDP2NlcnRpZmljYXRlUmV2b2Nh\\ndGlvbkxpc3Q/YmFzZTCB36CB3KCB2YaB1mh0dHBzOi8vcG9ydGFsLW9wZXJhZG9yLnNlY3VyaXR5\\nZGF0YS5uZXQuZWMvZWpiY2EvcHVibGljd2ViL3dlYmRpc3QvY2VydGRpc3Q/Y21kPWNybCZpc3N1\\nZXI9Q049QVVUT1JJREFEIERFIENFUlRJRklDQUNJT04gU1VCQ0EtMSBTRUNVUklUWSBEQVRBLE9V\\nPUVOVElEQUQgREUgQ0VSVElGSUNBQ0lPTiBERSBJTkZPUk1BQ0lPTixPPVNFQ1VSSVRZIERBVEEg\\nUy5BLiAxLEM9RUMwCwYDVR0PBAQDAgXgMCAGA1UdEQQZMBeBFXZlcml0b3l1bmdhbkB5YWhvby5l\\nczAaBgorBgEEAYKmcgMBBAwMCjA2MDQ5Njc1NTQwHQYKKwYBBAGCpnIDAgQPDA1FTFNBIFZFUk9O\\nSUNBMBYGCisGAQQBgqZyAwMECAwGWVVOR0FOMBYGCisGAQQBgqZyAwQECAwGR1VBTExJMCcGCisG\\nAQQBgqZyAwcEGQwXR1VBWUFRVUlMIFkgRUxPWSBBTEZBUk8wHAYKKwYBBAGCpnIDCAQODAw1OTM5\\nNzg4MzI4NzIwGAYKKwYBBAGCpnIDCQQKDAhSSU9CQU1CQTAdBgorBgEEAYKmcgMLBA8MDTA2MDQ5\\nNjc1NTQwMDEwFwYKKwYBBAGCpnIDDAQJDAdFQ1VBRE9SMBEGCisGAQQBgqZyAx0EAwwBLjARBgor\\nBgEEAYKmcgMeBAMMAS4wHwYKKwYBBAGCpnIDIAQRDA8wMDEwMDIwMDAwNDIxNTcwEwYKKwYBBAGC\\npnIDIQQFDANQRlgwEQYKKwYBBAGCpnIDIgQDDAEuMBEGCisGAQQBgqZyAyMEAwwBLjANBgkqhkiG\\n9w0BAQsFAAOCAgEAiNrjQp4K89HrTdX+mEpQc0C46Mv+0l0YD9ki38K4bzMFmQNhdt/WLiq/Os8W\\ngjMgcSlJbxyXpDoJ60GiL2nYOamCEqVal5PqzWbQolhootjwhjfqvo70f54Fzl7wS7xmcbCjPhJL\\n4CN0W7NYLlqm1BgsVmA39MXNzXWlxV1QSnHvaKC+JFqPnfgMWZLs1W3MQgXlKdbW2CKa54lQQ8Gk\\njvW/Rp8h1a2sHK6Stt3bondtY/tx8qAVClFU9zJKo3sG107ZYWwW+gq92ZySxEYZAxLCAjFceGyt\\nU1xhiECa1G7Z1PoZvhfScNiJA4DYDUDHW08ZSA36JiL1RT/jXMrTnbwHL50RzNDX5eWAcA33fLgW\\ngh6mS4KhtaXruRxt7f/jsEbHtDk70m1V2y3wdwAFU8UKjcfD5JnExKOdLQLOvldvCxl+/Ogg9rLQ\\ncF7PzFTgtKMs8/67316D+kLYsz/9NVx2rQ6oBh8zJyUuKbAs8IGGynVgmOBAikdG2mABqj3rfQ3X\\nGhwJdBIPiWy5EoMuE7ro5VATSTTCXY0pzm6ulLERXg8dGq5qbKIdSn4IJZHNJfvQ4bAgJDPGk0tW\\nfRBm2+6KLH1qbh+59dwnsHC2KxFszLvvmNdZteWhDly4k1ZVjttW2Krmfy6GrX9smmAbGG2FVLMN\\n7/5W0oWYlPLH9lE\\u003d\\n\\u003c/ds:X509Certificate\\u003e\\n\\u003c/ds:X509Data\\u003e\\n\\u003cds:KeyValue\\u003e\\n\\u003cds:RSAKeyValue\\u003e\\n\\u003cds:Modulus\\u003e\\ny7cqF5o6L3eWAqj+LfzoU2l08OuO17ityoQAIGEsuDvvo9epPHqsIYJ8NGyS43frohGgnA/aN0H3\\nrcv+jOSgxaZDo586NiHyuD9D/xokuWDpz9LnwMQk/bChsdr7X6QZxffsOegmamT9aBZPywHiX6Ln\\n2ipS6Wcs0K9KB+m36DiwJDH3oM/8V+nfIM2nvZLO6iBOjjgqBF8k0Igg67PrwPerC9ir9A+evdXK\\nsY+vmfVlhVVYyAIvpdjTYXCsfXn+y0f5oHATu/oCqphnrWfsZSukJdji+JCpbhAHm2sAPDdG+E38\\nd/iNKR7u1ZIUq0hPfIxV4GXNUfJnYGaZ1ROxQw\\u003d\\u003d\\n\\u003c/ds:Modulus\\u003e\\n\\u003cds:Exponent\\u003eAQAB\\u003c/ds:Exponent\\u003e\\n\\u003c/ds:RSAKeyValue\\u003e\\n\\u003c/ds:KeyValue\\u003e\\n\\u003c/ds:KeyInfo\\u003e\\n\\u003cds:Object Id\\u003d\\\"Signature639009-Object123053\\\"\\u003e\\u003cetsi:QualifyingProperties Target\\u003d\\\"#Signature639009\\\"\\u003e\\u003cetsi:SignedProperties Id\\u003d\\\"Signature639009-SignedProperties492569\\\"\\u003e\\u003cetsi:SignedSignatureProperties\\u003e\\u003cetsi:SigningTime\\u003e2020-12-05T19:31:29-05:00\\u003c/etsi:SigningTime\\u003e\\u003cetsi:SigningCertificate\\u003e\\u003cetsi:Cert\\u003e\\u003cetsi:CertDigest\\u003e\\u003cds:DigestMethod Algorithm\\u003d\\\"http://www.w3.org/2000/09/xmldsig#sha1\\\"/\\u003e\\u003cds:DigestValue\\u003e2eX+9AE35vuVIZ8rBJEqqqgvfps\\u003d\\u003c/ds:DigestValue\\u003e\\u003c/etsi:CertDigest\\u003e\\u003cetsi:IssuerSerial\\u003e\\u003cds:X509IssuerName\\u003eCN\\u003dAUTORIDAD DE CERTIFICACION SUBCA-1 SECURITY DATA,OU\\u003dENTIDAD DE CERTIFICACION DE INFORMACION,O\\u003dSECURITY DATA S.A. 1,C\\u003dEC\\u003c/ds:X509IssuerName\\u003e\\u003cds:X509SerialNumber\\u003e1767749973\\u003c/ds:X509SerialNumber\\u003e\\u003c/etsi:IssuerSerial\\u003e\\u003c/etsi:Cert\\u003e\\u003c/etsi:SigningCertificate\\u003e\\u003c/etsi:SignedSignatureProperties\\u003e\\u003cetsi:SignedDataObjectProperties\\u003e\\u003cetsi:DataObjectFormat ObjectReference\\u003d\\\"#Reference-ID-593387\\\"\\u003e\\u003cetsi:Description\\u003econtenido comprobante\\u003c/etsi:Description\\u003e\\u003cetsi:MimeType\\u003etext/xml\\u003c/etsi:MimeType\\u003e\\u003c/etsi:DataObjectFormat\\u003e\\u003c/etsi:SignedDataObjectProperties\\u003e\\u003c/etsi:SignedProperties\\u003e\\u003c/etsi:QualifyingProperties\\u003e\\u003c/ds:Object\\u003e\\u003c/ds:Signature\\u003e\\u003c/factura\\u003e\",\"mensajes\":[],\"__hashCodeCalc\":false}],\"__hashCodeCalc\":false}";
        try {
            AutorizacionComprobantesWs comprobantesWs = new AutorizacionComprobantesWs(
                    "https://cel.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl");

            String clave ="0512202001060496755400120010020000033941234567812";
            RespuestaComprobante result = comprobantesWs.llamadaWSAutorizacionInd(clave);
            // assert
            Gson gson = new Gson();

            // System.out.println(comprobantesWs.obtenerMensajeRespuesta(result));
            String res = gson.toJson(result);
            System.out.println(gson.toJson(res));
            assertEquals(expected, res);

        } catch (Exception e) {

            System.err.println("" + e.getMessage());
            assertEquals(expected, e.getMessage());
        }
    }
}