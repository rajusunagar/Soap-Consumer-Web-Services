
package com.soap.ConsumerWebService.number;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumberToWordsResult" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numberToWordsResult"
})
@XmlRootElement(name = "NumberToWordsResponse")
public class NumberToWordsResponse {

    /**
     * -- GETTER --
     *  Gets the value of the numberToWordsResult property.
     *
     *
     * -- SETTER --
     *  Sets the value of the numberToWordsResult property.
     *
     @return
     *     possible object is
     *     {@link String }
      * @param value
      *     allowed object is
      *     {@link String }
     */
    @XmlElement(name = "NumberToWordsResult", required = true)
    protected String numberToWordsResult;

}
