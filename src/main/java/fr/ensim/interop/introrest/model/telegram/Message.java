package fr.ensim.interop.introrest.model.telegram;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * This object represents a message.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message implements BotApiObject {

	private static final String MESSAGEID_FIELD = "message_id";
	private static final String FROM_FIELD = "from";
	private static final String DATE_FIELD = "date";
	private static final String CHAT_FIELD = "chat";
	private static final String FORWARDFROM_FIELD = "forward_from";
	private static final String FORWARDFROMCHAT_FIELD = "forward_from_chat";
	private static final String FORWARDDATE_FIELD = "forward_date";
	private static final String TEXT_FIELD = "text";
	private static final String ENTITIES_FIELD = "entities";
	private static final String CAPTIONENTITIES_FIELD = "caption_entities";
	private static final String AUDIO_FIELD = "audio";
	private static final String DOCUMENT_FIELD = "document";
	private static final String PHOTO_FIELD = "photo";
	private static final String STICKER_FIELD = "sticker";
	private static final String VIDEO_FIELD = "video";
	private static final String CONTACT_FIELD = "contact";
	private static final String LOCATION_FIELD = "location";
	private static final String VENUE_FIELD = "venue";
	private static final String ANIMATION_FIELD = "animation";
	private static final String PINNED_MESSAGE_FIELD = "pinned_message";
	private static final String NEWCHATMEMBERS_FIELD = "new_chat_members";
	private static final String LEFTCHATMEMBER_FIELD = "left_chat_member";
	private static final String NEWCHATTITLE_FIELD = "new_chat_title";
	private static final String NEWCHATPHOTO_FIELD = "new_chat_photo";
	private static final String DELETECHATPHOTO_FIELD = "delete_chat_photo";
	private static final String GROUPCHATCREATED_FIELD = "group_chat_created";
	private static final String REPLYTOMESSAGE_FIELD = "reply_to_message";
	private static final String VOICE_FIELD = "voice";
	private static final String CAPTION_FIELD = "caption";
	private static final String SUPERGROUPCREATED_FIELD = "supergroup_chat_created";
	private static final String CHANNELCHATCREATED_FIELD = "channel_chat_created";
	private static final String MIGRATETOCHAT_FIELD = "migrate_to_chat_id";
	private static final String MIGRATEFROMCHAT_FIELD = "migrate_from_chat_id";
	private static final String EDITDATE_FIELD = "edit_date";
	private static final String GAME_FIELD = "game";
	private static final String FORWARDFROMMESSAGEID_FIELD = "forward_from_message_id";
	private static final String INVOICE_FIELD = "invoice";
	private static final String SUCCESSFUL_PAYMENT_FIELD = "successful_payment";
	private static final String VIDEO_NOTE_FIELD = "video_note";
	private static final String AUTHORSIGNATURE_FIELD = "author_signature";
	private static final String FORWARDSIGNATURE_FIELD = "forward_signature";
	private static final String MEDIAGROUPID_FIELD = "media_group_id";
	private static final String CONNECTEDWEBSITE_FIELD = "connected_website";
	private static final String PASSPORTDATA_FIELD = "passport_data";
	private static final String FORWARDSENDERNAME_FIELD = "forward_sender_name";
	private static final String POLL_FIELD = "poll";
	private static final String REPLY_MARKUP_FIELD = "reply_markup";
	private static final String DICE_FIELD = "dice";
	private static final String VIABOT_FIELD = "via_bot";
	private static final String SENDERCHAT_FIELD = "sender_chat";
	private static final String PROXIMITYALERTTRIGGERED_FIELD = "proximity_alert_triggered";
	private static final String MESSAGEAUTODELETETIMERCHANGED_FIELD = "message_auto_delete_timer_changed";
	private static final String ISAUTOMATICFORWARD_FIELD = "is_automatic_forward";
	private static final String HASPROTECTEDCONTENT_FIELD = "has_protected_content";
	private static final String WEBAPPDATA_FIELD = "web_app_data";
	private static final String VIDEOCHATSCHEDULED_FIELD = "video_chat_scheduled";
	private static final String VIDEOCHATSTARTED_FIELD = "video_chat_started";
	private static final String VIDEOCHATENDED_FIELD = "video_chat_ended";
	private static final String VIDEOCHATPARTICIPANTSINVITED_FIELD = "video_chat_participants_invited";
	
	@JsonProperty(MESSAGEID_FIELD)
	private Integer messageId; ///< Integer	Unique message identifier
	@JsonProperty(FROM_FIELD)
	private User from; ///< Optional. Sender, can be empty for messages sent to channels
	@JsonProperty(DATE_FIELD)
	private Integer date; ///< Date the message was sent in Unix time
	@JsonProperty(CHAT_FIELD)
	private Chat chat; ///< Conversation the message belongs to
	@JsonProperty(FORWARDFROM_FIELD)
	private User forwardFrom; ///< Optional. For forwarded messages, sender of the original message
	/**
	 * Optional.
	 * For messages forwarded from channels or from anonymous administrators, information about the original sender chat
	 */
	@JsonProperty(FORWARDFROMCHAT_FIELD)
	private Chat forwardFromChat;
	@JsonProperty(FORWARDDATE_FIELD)
	private Integer forwardDate; ///< Optional. For forwarded messages, date the original message was sent
	@JsonProperty(TEXT_FIELD)
	private String text; ///< Optional. For text messages, the actual UTF-8 text of the message
	/**
	 * Optional. For text messages, special entities like usernames, URLs,
	 * bot commands, etc. that appear in the text
	 */
	@JsonProperty(ENTITIES_FIELD)
	private List<MessageEntity> entities;
	/**
	 * Optional. For messages with a caption, special entities like usernames,
	 * URLs, bot commands, etc. that appear in the caption
	 */
	@JsonProperty(CAPTIONENTITIES_FIELD)
	private List<MessageEntity> captionEntities;
	@JsonProperty(AUDIO_FIELD)
	private Audio audio; ///< Optional. Message is an audio file, information about the file
	@JsonProperty(DOCUMENT_FIELD)
	private Document document; ///< Optional. Message is a general file, information about the file
	@JsonProperty(PHOTO_FIELD)
	private List<PhotoSize> photo; ///< Optional. Message is a photo, available sizes of the photo
	@JsonProperty(VIDEO_FIELD)
	private Video video; ///< Optional. Message is a video, information about the video
	@JsonProperty(CONTACT_FIELD)
	private Contact contact; ///< Optional. Message is a shared contact, information about the contact
	@JsonProperty(LOCATION_FIELD)
	private Location location; ///< Optional. Message is a shared location, information about the location

	
	@JsonProperty(PINNED_MESSAGE_FIELD)
	private Message pinnedMessage; ///< Optional. Specified message was pinned. Note that the Message object in this field will not contain further reply_to_message fields even if it is itself a reply.
	@JsonProperty(NEWCHATMEMBERS_FIELD)
	private List<User> newChatMembers; ///< Optional. New members were added to the group or supergroup, information about them (the bot itself may be one of these members)
	@JsonProperty(LEFTCHATMEMBER_FIELD)
	private User leftChatMember; ///< Optional. A member was removed from the group, information about them (this member may be bot itself)
	@JsonProperty(NEWCHATTITLE_FIELD)
	private String newChatTitle; ///< Optional. A chat title was changed to this value
	@JsonProperty(NEWCHATPHOTO_FIELD)
	private List<PhotoSize> newChatPhoto; ///< Optional. A chat photo was change to this value
	@JsonProperty(DELETECHATPHOTO_FIELD)
	private Boolean deleteChatPhoto; ///< Optional. Informs that the chat photo was deleted
	@JsonProperty(GROUPCHATCREATED_FIELD)
	private Boolean groupchatCreated; ///< Optional. Informs that the group has been created
	@JsonProperty(REPLYTOMESSAGE_FIELD)
	private Message replyToMessage;
	@JsonProperty(CAPTION_FIELD)
	private String caption; ///< Optional. Caption for the document, photo or video, 0-200 characters
	/**
	 * Optional. Service message: the supergroup has been created.
	 * This field can‘t be received in a message coming through updates,
	 * because bot can’t be a member of a supergroup when it is created.
	 * It can only be found in reply_to_message
	 * if someone replies to a very first message in a directly created supergroup.
	 */
	@JsonProperty(SUPERGROUPCREATED_FIELD)
	private Boolean superGroupCreated;
	/**
	 * Optional. Service message: the channel has been created.
	 * This field can‘t be received in a message coming through updates,
	 * because bot can’t be a member of a channel when it is created.
	 * It can only be found in reply_to_message if someone
	 * replies to a very first message in a channel.
	 */
	@JsonProperty(CHANNELCHATCREATED_FIELD)
	private Boolean channelChatCreated;
	/**
	 * Optional. The group has been migrated to a supergroup with the specified identifier.
	 * This number may be greater than 32 bits and some programming languages
	 * may have difficulty/silent defects in interpreting it.
	 * But it smaller than 52 bits, so a signed 64 bit integer or double-precision
	 * float type are safe for storing this identifier.
	 */
	@JsonProperty(MIGRATETOCHAT_FIELD)
	private Long migrateToChatId; ///< Optional. The chat has been migrated to a chat with specified identifier, not exceeding 1e13 by absolute value
	/**
	 * Optional. The supergroup has been migrated from a group with the specified identifier.
	 * This number may be greater than 32 bits and some programming languages
	 * may have difficulty/silent defects in interpreting it.
	 * But it smaller than 52 bits, so a signed 64 bit integer or double-precision
	 * float type are safe for storing this identifier.
	 */
	@JsonProperty(MIGRATEFROMCHAT_FIELD)
	private Long migrateFromChatId; ///< Optional. The chat has been migrated from a chat with specified identifier, not exceeding 1e13 by absolute value
	@JsonProperty(EDITDATE_FIELD)
	private Integer editDate; ///< Optional. Date the message was last edited in Unix time
	
	/**
	 * Optional.
	 * Signature of the post author for messages in channels, or the custom title of an anonymous group administrator
	 */
	@JsonProperty(AUTHORSIGNATURE_FIELD)
	private String authorSignature;
	@JsonProperty(FORWARDSIGNATURE_FIELD)
	private String forwardSignature; ///< Optional. Post author signature for messages forwarded from channel chats
	@JsonProperty(MEDIAGROUPID_FIELD)
	private String mediaGroupId; ///< Optional. The unique identifier of a media message group this message belongs to
	@JsonProperty(CONNECTEDWEBSITE_FIELD)
	private String connectedWebsite; ///< Optional. The domain name of the website on which the user has logged in
	@JsonProperty(FORWARDSENDERNAME_FIELD)
	private String forwardSenderName; ///< Optional. Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages.
	@JsonProperty(VIABOT_FIELD)
	private User viaBot; // Optional. Bot through which the message was sent
	/**
	 * Optional.
	 * Sender of the message, sent on behalf of a chat. The channel itself for channel messages.
	 * The supergroup itself for messages from anonymous group administrators.
	 * The linked channel for messages automatically forwarded to the discussion group
	 */
	@JsonProperty(SENDERCHAT_FIELD)
	private Chat senderChat;

	/**
	 * Optional.
	 * True, if the message is a channel post that was automatically forwarded to the connected discussion group
	 */
	private Boolean isAutomaticForward;
	@JsonProperty(HASPROTECTEDCONTENT_FIELD)
	private Boolean hasProtectedContent; ///< Optional. True, if the message can't be forwarded
	
	public List<MessageEntity> getEntities() {
		if (entities != null) {
			entities.forEach(x -> x.computeText(text));
		}
		return entities;
	}
	
	public List<MessageEntity> getCaptionEntities() {
		if (captionEntities != null) {
			captionEntities.forEach(x -> x.computeText(caption));
		}
		return captionEntities;
	}
	
	@JsonIgnore
	public List<User> getNewChatMembers() {
		return newChatMembers == null ? new ArrayList<>() : newChatMembers;
	}
	
	@JsonIgnore
	public boolean isGroupMessage() {
		return chat.isGroupChat();
	}
	
	@JsonIgnore
	public boolean isUserMessage() {
		return chat.isUserChat();
	}
	
	@JsonIgnore
	public boolean isChannelMessage() {
		return chat.isChannelChat();
	}
	
	@JsonIgnore
	public boolean isSuperGroupMessage() {
		return chat.isSuperGroupChat();
	}
	
	@JsonIgnore
	public Long getChatId() {
		return chat.getId();
	}
	
	@JsonIgnore
	public boolean hasText() {
		return text != null && !text.isEmpty();
	}
	
	@JsonIgnore
	public boolean hasDocument() {
		return this.document != null;
	}
	
	@JsonIgnore
	public boolean hasVideo() {
		return this.video != null;
	}
	
	@JsonIgnore
	public boolean hasAudio() {
		return this.audio != null;
	}
	
	@JsonIgnore
	public boolean isReply() {
		return this.replyToMessage != null;
	}
	
	@JsonIgnore
	public boolean hasLocation() {
		return location != null;
	};
	
	@JsonIgnore
	public boolean hasEntities() {
		return entities != null && !entities.isEmpty();
	}
	
	@JsonIgnore
	public boolean hasPhoto() {
		return photo != null && !photo.isEmpty();
	}
	
	@JsonIgnore
	public boolean hasContact() {
		return contact != null;
	}
	
	@JsonIgnore
	public boolean hasViaBot() {
		return viaBot != null;
	}
}
